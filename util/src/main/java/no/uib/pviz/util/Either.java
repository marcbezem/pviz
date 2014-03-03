package no.uib.pviz.util;

public abstract class Either<A,B> {
  public enum EitherHeader {LEFT,RIGHT}
  protected EitherHeader header;
  public EitherHeader type() {
    return header;
  }
  public A getLeft(){return null;}
  public B getRight(){return null;}

}

