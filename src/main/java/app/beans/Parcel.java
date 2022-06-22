package app.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "prcl")
@SessionScoped
public class Parcel implements Serializable {

	private double weight;
	private double distance;
	private double transportationCost;
	private String mode;
	private String result;

	// initialize
	public void initialize() {
		this.distance = 0.0;
		this.mode = "";
		this.result = "";
		this.transportationCost = 0.0;
		this.weight = 0.0;
	}

	// Calculate Price:
	public void CostParcel() {
		if (weight == 0.0) {
			showError("Please Enter the Weight !!");
			return;
		}

		if (distance == 0.0) {
			showError("Please Enter the distance !!");
			return;
		}

		if (distance <= 100) {
			if (weight <= 15) {
				transportationCost = weight * 5;
			} else if (weight <= 30) {
				transportationCost = weight * 7.5;
			} else {
				transportationCost = weight * 10;
			}
		} else {
			if (weight <= 15) {
				transportationCost = weight * 8;
			} else if (weight <= 30) {
				transportationCost = weight * 9;
			} else {
				transportationCost = weight * 11;
			}
		}

		if (mode.equals("express"))
			transportationCost *= 1.05;

		result = "Your Cost is : " + String.valueOf(transportationCost);
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public double getTransportationCost() {
		return transportationCost;
	}

	public void setTransportationCost(double transportationCost) {
		this.transportationCost = transportationCost;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getResut() {
		return result;
	}

	public void setResut(String resut) {
		this.result = resut;
	}

	public Parcel() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Parcel [weight=" + weight + ", distance=" + distance + ", transportationCost=" + transportationCost
				+ ", mode=" + mode + ", result=" + result + "]";
	}

	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, detail));
	}

	public void showError(String message) {
		addMessage(FacesMessage.SEVERITY_ERROR, "Error Message", message);
	}

}
