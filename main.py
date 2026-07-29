import os
import json
import firebase_admin
from firebase_admin import credentials, firestore

def initialize_services():
    print("[1/2] جاري الاتصال بخدمات Google Cloud و Firebase...")
    
    # قراءة المفتاح المشفر من Secrets
    service_account_env = os.environ.get('FIREBASE_SERVICE_ACCOUNT')
    
    if not service_account_env:
        print("❌ خطأ: لم يتم العثور على المتغير FIREBASE_SERVICE_ACCOUNT في إعدادات البيئة!")
        return None

    try:
        # تحويل نص المفتاح إلى بيانات مفعلة
        service_account_info = json.loads(service_account_env)
        
        # تهيئة تطبيق Firebase Admin
        cred = credentials.Certificate(service_account_info)
        firebase_admin.initialize_app(cred)
        
        print("✓ تم الاتصال بـ Firebase بنجاح وبصلاحيات المالك الكاملة.")
        
        # اختبار الاتصال بقاعدة البيانات Firestore
        db = firestore.client()
        print("✓ محرك البيانات Firestore جاهز للعمل.")
        return db

    except Exception as e:
        print(f"❌ حدث خطأ أثناء الاتصال: {str(e)}")
        return None

if __name__ == "__main__":
    print("=== بدء تشغيل المحرك الرئيسي SmartForge AI ===")
    db = initialize_services()
    if db:
        print("=== النظام مكتمل وجاهز للعمل سحابياً بنجاح! ===")
      
