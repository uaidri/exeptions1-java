package entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.zip.CheckedOutputStream;

public class Reservation {
	
	private Integer roomNumber;
	Date checkOut;
	Date checkIn;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation(Integer roomNumber, Date checkOut, Date checkIn) {
		super();
		this.roomNumber = roomNumber;
		this.checkOut = checkOut;
		this.checkIn = checkIn;
	}



	public Integer getRoomNumber() {
		return roomNumber;
	}



	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}



	public Date getCheckOut() {
		return checkOut;
	}

	

	public Date getCheckIn() {
		return checkIn;
	}
	

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MICROSECONDS);
		
	}
	public void updateDates(Date checkIn, Date checkOut) {
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}



	@Override
	public String toString() {
		return "Room " + roomNumber +
				", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkIn)
				+ ", "
				+ duration()
				+" nights";
	}




}
