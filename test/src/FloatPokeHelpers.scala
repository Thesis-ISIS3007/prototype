package prototype

import java.lang.Float
import java.lang.Integer.toUnsignedLong

import chisel3._

object FloatPokeHelpers {
  def f32(value: Float): UInt =
    toUnsignedLong(Float.floatToRawIntBits(value)).U(32.W)
}
