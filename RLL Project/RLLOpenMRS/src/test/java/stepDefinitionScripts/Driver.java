package stepDefinitionScripts;

import org.openqa.selenium.chrome.ChromeDriver;
import pages.AppointmentRequestsPage;
import pages.AppointmentSchedulingPage;
import pages.CaptureVitalsPage;
import pages.CreateAppointment;
import pages.EditDetailsPage;
import pages.EnterDetails;
import pages.HomePage;
import pages.LandingPage;
import pages.ManageAppoinmentsPage;
import pages.ManageBlock;
import pages.ManageServiceTypePage;
import pages.PatientAppointmentPage;
import pages.RecordVitalsPage;
import pages.SearchPatient;
import pages.VerifyPage;
import utils.Tools;

public class Driver extends Tools {
	
	protected static LandingPage landingpage;
	protected static HomePage HomePage;
	protected static SearchPatient searchPatientPage;
	protected static EditDetailsPage editDetailsPage;
	protected static VerifyPage verifyPage;
	protected static AppointmentSchedulingPage appointmentSchedulingPage;
	protected static ManageAppoinmentsPage manageAppoinmentsPage;
	protected static PatientAppointmentPage patientAppointmentPage;
	protected static AppointmentRequestsPage appointmentRequestsPage;
	protected static CaptureVitalsPage captureVitalsPage;
	protected static RecordVitalsPage recordVitalsPage;
	protected static ManageBlock manageBlock;
	protected static CreateAppointment createBlock;
	protected static  EnterDetails enterDetails;
	protected static  ManageServiceTypePage manageServiceTypePage;

	public static void init() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		landingpage = new LandingPage(driver);
		HomePage = new HomePage(driver);
		searchPatientPage = new SearchPatient(driver);
		editDetailsPage = new EditDetailsPage(driver);
		verifyPage = new VerifyPage(driver);
		
		appointmentSchedulingPage = new AppointmentSchedulingPage(driver);
		manageAppoinmentsPage = new ManageAppoinmentsPage(driver);
		patientAppointmentPage = new PatientAppointmentPage(driver);
		appointmentRequestsPage = new AppointmentRequestsPage(driver);
		captureVitalsPage = new CaptureVitalsPage(driver);
		recordVitalsPage = new RecordVitalsPage(driver);
		manageBlock = new ManageBlock(driver);
		createBlock = new CreateAppointment(driver);
		enterDetails = new EnterDetails(driver);
		manageServiceTypePage = new ManageServiceTypePage(driver);
	}
}