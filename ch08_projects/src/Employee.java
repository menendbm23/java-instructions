
public class Employee extends Person {

		private String ssn;

		public Employee(String firstName, String lastName, String ssn) {
			super(firstName, lastName);
			this.ssn = ssn;
		}

		public String getSsn() {
			return "xxxxx"+ ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}

		@Override
		public String toString() {
			return "Employee [ssn=" + ssn + ", toString()=" + super.toString() + "]";
		}
		
		
		
}
