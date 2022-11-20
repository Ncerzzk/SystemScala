
object Hello {
  def main(args: Array[String]): Unit =  {
    print("hello world")
  }
}

trait IODirection{
  def applyIt[T <: Data](data: T): T
  def apply[T <: Data](data: T): T = applyIt(data)
}

trait Data{
  var dir:IODirection=_
  def as_input(): this.type={
    dir=in
    this
  }

  def as_output(): this.type={
    dir=out
    this
  }

  def as_inout():this.type={
    dir=inout
    this
  }
}
object in extends IODirection {
  override def applyIt[T <: Data](data: T): T = data.as_input()
}

object out extends IODirection {
  override def applyIt[T <: Data](data: T): T = data.as_output()
}

object inout extends IODirection {
  override def applyIt[T <: Data](data: T): T = data.as_inout()
}

class Clk extends Data{
}

class Mem extends Data{
  def <>(mem:Mem)={

  }
}

class SimpleCPU{
  var clk = in(new Clk)
  var mem = inout(new Mem)
  def Run(): Unit ={

  }


}