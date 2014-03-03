package no.uib.pviz.util;

public class Right<A,B> extends Either<A,B> {
  private B right;
  public Right(B right) {
    super.header=EitherHeader.RIGHT;
    this.right=right;
  }
  @Override
  public B getRight(){
    return right;
  }
}
