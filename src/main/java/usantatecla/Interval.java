package usantatecla;

public class Interval {
	private Min min;

	private Max max;

	public Interval(Min min, Max max) {
		assert min.value <= max.value;
		this.min = min;
		this.max = max;
	}

	public boolean contains(double value) {
			return this.min.contains(value) && this.max.contains(value);
	}

	public boolean contains(Interval interval) {
		return this.contains(interval.min.value) || this.contains(interval.max.value);
	}

	public boolean isSameLimits(Interval intervalToCompare) {
		return this.min.equals(intervalToCompare.min) || this.max.equals(intervalToCompare.max);
	}

	public boolean isIntersected(Interval intervalToCompare) {
		return this.contains(intervalToCompare)|| intervalToCompare.contains(this)
				|| isSameLimits(intervalToCompare);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((max == null) ? 0 : max.hashCode());
		result = prime * result + ((min == null) ? 0 : min.hashCode());
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
		Interval other = (Interval) obj;
		if (max == null) {
			if (other.max != null)
				return false;
		} else if (!max.equals(other.max))
			return false;
		if (min == null) {
			if (other.min != null)
				return false;
		} else if (!min.equals(other.min))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return this.min.toString() + ", " + max.toString();
	}
}