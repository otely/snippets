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
        
