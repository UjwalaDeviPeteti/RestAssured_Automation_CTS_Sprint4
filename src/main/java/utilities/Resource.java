package utilities;

public enum Resource {

	
	AuthpostResource("/OAuthRestApi/webapi/auth/login"),
	TokenpostResource("/OAuthRestApi/webapi/auth/token"),
	AddbookingpostResource("/TrainAPI/BookingService/addBooking"),
	getListResource("/TrainAPI/BookingService/viewBookingList"),
	getIdResource("/TrainAPI/BookingService/viewBookingById/{id}"),
	getClassResource("/TrainAPI/BookingService/viewBookingByClass"),
	deleteResource("/TrainAPI/BookingService/deleteBookingById/{id}");
	
	
	private String Resource;
	
	public String getResource() {
		return Resource;
	}
	
	Resource(String Resource){
		this.Resource=Resource;
	}
	
}
