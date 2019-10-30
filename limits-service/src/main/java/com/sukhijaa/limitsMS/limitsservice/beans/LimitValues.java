package com.sukhijaa.limitsMS.limitsservice.beans;

public class LimitValues {

  private int minimum;
  private int maximum;

  protected LimitValues() {

  }

  public LimitValues(int minimum, int maximum) {
    this.minimum = minimum;
    this.maximum = maximum;
  }

  public int getMinimum() {
    return minimum;
  }

  public int getMaximum() {
    return maximum;
  }
}
