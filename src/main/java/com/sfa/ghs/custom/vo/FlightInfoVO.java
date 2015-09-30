package com.sfa.ghs.custom.vo;

import java.util.Date;

public class FlightInfoVO {
	private String acRegNo;
	private String flightNo;
	private Date flihgtDate;
	private int dow;
	private int takeoffFuel;
	private int tripFuel;
	private int mtow;
	private String flightSect;
	private String crew;
	private boolean lifeRafts;
	private double doi;
	private double takeoffFuelIndex;
	private double loadingFuelIndex;
	private int mlw;
	private int ver;

	public String getAcRegNo() {
		return acRegNo;
	}

	public void setAcRegNo(String acRegNo) {
		this.acRegNo = acRegNo;
	}

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public Date getFlihgtDate() {
		return flihgtDate;
	}

	public void setFlihgtDate(Date flihgtDate) {
		this.flihgtDate = flihgtDate;
	}

	public int getDow() {
		return dow;
	}

	public void setDow(int dow) {
		this.dow = dow;
	}

	public int getTakeoffFuel() {
		return takeoffFuel;
	}

	public void setTakeoffFuel(int takeoffFuel) {
		this.takeoffFuel = takeoffFuel;
	}

	public int getTripFuel() {
		return tripFuel;
	}

	public void setTripFuel(int tripFuel) {
		this.tripFuel = tripFuel;
	}

	public int getMtow() {
		return mtow;
	}

	public void setMtow(int mtow) {
		this.mtow = mtow;
	}

	public String getFlightSect() {
		return flightSect;
	}

	public void setFlightSect(String flightSect) {
		this.flightSect = flightSect;
	}

	public String getCrew() {
		return crew;
	}

	public void setCrew(String crew) {
		this.crew = crew;
	}

	public boolean isLifeRafts() {
		return lifeRafts;
	}

	public void setLifeRafts(boolean lifeRafts) {
		this.lifeRafts = lifeRafts;
	}

	public double getDoi() {
		return doi;
	}

	public void setDoi(double doi) {
		this.doi = doi;
	}

	public double getTakeoffFuelIndex() {
		return takeoffFuelIndex;
	}

	public void setTakeoffFuelIndex(double takeoffFuelIndex) {
		this.takeoffFuelIndex = takeoffFuelIndex;
	}

	public double getLoadingFuelIndex() {
		return loadingFuelIndex;
	}

	public void setLoadingFuelIndex(double loadingFuelIndex) {
		this.loadingFuelIndex = loadingFuelIndex;
	}

	public int getMlw() {
		return mlw;
	}

	public void setMlw(int mlw) {
		this.mlw = mlw;
	}

	public int getVer() {
		return ver;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}
}
