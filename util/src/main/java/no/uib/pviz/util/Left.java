package no.uib.pviz.util;

public class Left<A,B> extends Either<A,B> {
  private A left;
  public Left(A left) {
    super.header=EitherHeader.LEFT;
    this.left=left;
  }
  @Override
  public A getLeft() {
    return left;
  }

}
