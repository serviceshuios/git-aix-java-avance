package com.ib.demoJPA.metier;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LONG")
public class LongMetrage extends Film {
	private String cinema;

	public String getCinema() {
		return cinema;
	}

	public void setCinema(String cinema) {
		this.cinema = cinema;
	}

	@Override
	public String toString() {
		return "LongMetrage [cinema=" + cinema + ", toString()=" + super.toString() + "]";
	}
}
