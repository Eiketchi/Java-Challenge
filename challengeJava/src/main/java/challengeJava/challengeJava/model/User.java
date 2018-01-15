package challengeJava.challengeJava.model;

public class User {
	 private String email;
	 private String password;
	
	   
	///*******************************getter & setter*************///
	 public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
			
		
		/***************************** to string ****************************/
		@Override
		public String toString() {
			return "User [email=" + email + ", password=" + password + "]";
		}
		
}
