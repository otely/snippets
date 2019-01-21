public static boolean executeShellCommandAsRoot(String cmd){
		        Process process = null;            
		        try{
		            process = Runtime.getRuntime().exec("su");         	      
		            DataOutputStream os = new DataOutputStream(process.getOutputStream());            	            
		            os.writeBytes(cmd+"\n");
		            os.flush();           
		            os.writeBytes("exit\n");  
		            os.flush();
		            process.waitFor();	            
		            return true;
		        } catch (IOException e) {
		        	 e.printStackTrace();
		            return false;
		            
		        }catch(InterruptedException e){
		            e.printStackTrace();
		            return false;
		        } finally{
		            if(process != null){
		                try{
		                    process.destroy();
		                }catch (Exception e) {
		                }
		            }
		        }
		    }

public static hideapps(boolean state) {
	if (state){  //Hide app's icon using below code:
		PackageManager p = getPackageManager();
  		ComponentName componentName = new ComponentName(this, com.apps.MainActivity.class); // activity which is first time open in manifiest file which is declare as <category android:name="android.intent.category.LAUNCHER" />
		p.setComponentEnabledSetting(componentName,PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
	}else { //Here is how to bring back the app's icon.
		PackageManager p = getPackageManager();
		ComponentName componentName = new ComponentName(this, com.apps.MainActivity.class);
		p.setComponentEnabledSetting(componentName, PackageManager.COMPONENT_ENABLED_STATE_ENABLED, PackageManager.DONT_KILL_APP);
	}
}

public static boolean isDeviceRooted() { // test existance of root access
		        return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
		    }

		    private static boolean checkRootMethod1() {
		        String buildTags = android.os.Build.TAGS;
		        return buildTags != null && buildTags.contains("test-keys");
		    }

		    private static boolean checkRootMethod2() {
		        String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
		                "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
		        for (String path : paths) {
		            if (new File(path).exists()) return true;
		        }
		        return false;
		    }

		    private static boolean checkRootMethod3() {
		        Process process = null;
		        try {
		            process = Runtime.getRuntime().exec(new String[] { "/system/xbin/which", "su" });
		            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
		            if (in.readLine() != null) return true;
		            return false;
		        } catch (Throwable t) {
		            return false;
		        } finally {
		            if (process != null) process.destroy();
		        }
		    }        
        
