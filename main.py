import os
import json
import firebase_admin
from firebase_admin import credentials, firestore
import google.generativeai as genai

def run_smartforge_engine():
    print("=== [1/2] اختبار الاتصال بخدمات Google Cloud & Firebase ===")
    
    # جلب مفتاح Firebase المشفر من الأسرار
    fb_secret = os.environ.get('FIREBASE_SERVICE_ACCOUNT')
    if not fb_secret:
        print("❌ خطأ: لم يتم العثور على FIREBASE_SERVICE_ACCOUNT في الأسرار!")
        return

    try:
        cred = credentials.Certificate(json.loads(fb_secret))
        if not firebase_admin._apps:
            firebase_admin.initialize_app(cred)
        db = firestore.client()
        print("✓ تم الاتصال بـ Firebase و Firestore بنجاح وبصلاحيات المالك الكاملة.")
    except Exception as e:
        print(f"❌ خطأ أثناء الاتصال بـ Firebase: {e}")
        return

    print("\n=== [2/2] اختبار محرك الذكاء الاصطناعي Gemini AI ===")
    gemini_key = os.environ.get('GEMINI_API_KEY')
    if not gemini_key:
        print("⚠️ تنبيه: لم يتم العثور على GEMINI_API_KEY في الأسرار.")
        return

    try:
        genai.configure(api_key=gemini_key)
        model = genai.GenerativeModel('gemini-1.5-pro')
        
        prompt = "قم بتقديم نفسك بكلمتين كذكاء اصطناعي تابع لمشروع SmartForge AI"
        response = model.generate_content(prompt)
        
        print("✓ رد الذكاء الاصطناعي بنجاح:")
        print(f"-> {response.text.strip()}")
    except Exception as e:
        print(f"❌ خطأ أثناء تشغيل Gemini: {e}")

if __name__ == "__main__":
    run_smartforge_engine()
    
