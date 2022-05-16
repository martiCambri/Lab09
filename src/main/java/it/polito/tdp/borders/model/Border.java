package it.polito.tdp.borders.model;

public class Border {
	
	private int state1num;
	private int state2num;
	private String state1ab;
	private String state2ab;
	
	public Border(int state1num, int state2num, String state1ab, String state2ab) {
		
		this.state1num = state1num;
		this.state2num = state2num;
		this.state1ab = state1ab;
		this.state2ab = state2ab;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((state1ab == null) ? 0 : state1ab.hashCode());
		result = prime * result + state1num;
		result = prime * result + ((state2ab == null) ? 0 : state2ab.hashCode());
		result = prime * result + state2num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Border other = (Border) obj;
		if (state1ab == null) {
			if (other.state1ab != null)
				return false;
		} else if (!state1ab.equals(other.state1ab))
			return false;
		if (state1num != other.state1num)
			return false;
		if (state2ab == null) {
			if (other.state2ab != null)
				return false;
		} else if (!state2ab.equals(other.state2ab))
			return false;
		if (state2num != other.state2num)
			return false;
		return true;
	}

	public int getState1num() {
		return state1num;
	}

	public int getState2num() {
		return state2num;
	}

	public String getState1ab() {
		return state1ab;
	}

	public String getState2ab() {
		return state2ab;
	}

	public void setState1num(int state1num) {
		this.state1num = state1num;
	}

	public void setState2num(int state2num) {
		this.state2num = state2num;
	}

	public void setState1ab(String state1ab) {
		this.state1ab = state1ab;
	}

	public void setState2ab(String state2ab) {
		this.state2ab = state2ab;
	}

	@Override
	public String toString() {
		return "Border [state1num=" + state1num + ", state2num=" + state2num + ", state1ab=" + state1ab + ", state2ab="
				+ state2ab + "]";
	}

	
	
	

}
