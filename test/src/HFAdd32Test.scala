package prototype

import org.scalatest.funspec.AnyFunSpec

import java.lang.Float

import chisel3._
import chisel3.simulator.scalatest.ChiselSim

import FloatPokeHelpers.f32

class HFAdd32Test extends AnyFunSpec with ChiselSim {
  describe("HardFloat AddRecFN Example") {
    it("should add two 32-bit floating point numbers") {
      simulate(new HF32Add) { c =>
        // Test case 1: 1.0 + 2.0 = 3.0
        c.io.sub.poke(false.B)
        c.io.a.poke(f32(1.0f))
        c.io.b.poke(f32(2.0f))
        c.clock.step()
        c.io.out.expect(f32(3.0f))

        // Test case 2: -1.5 + 0.5 = -1.0
        c.io.sub.poke(false.B)
        c.io.a.poke(f32(-1.5f))
        c.io.b.poke(f32(0.5f))
        c.clock.step()
        c.io.out.expect(f32(-1.0f))

        // Test case 3: NaN + any number = NaN
        c.io.sub.poke(false.B)
        c.io.a.poke(f32(Float.NaN))
        c.io.b.poke(f32(2.0f))
        c.clock.step()
        val outBits = c.io.out.peek().litValue.toInt
        val outF32 = Float.intBitsToFloat(outBits)
        assert(
          outF32.isNaN,
          f"expected NaN, got bits 0x${outBits & 0xffffffffL}%08x"
        )
      }
    }
  }
}
