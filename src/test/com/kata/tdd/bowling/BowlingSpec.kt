package com.kata.tdd.bowling

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BowlingSpec : BehaviorSpec({

    Given("a bowling game") {

        When("not all pins are down in each frame") {
            val game = Bowling()
            repeat(20, { game.roll(4) })
            Then("score is sum of pins down") {
                game.getScore().shouldBe(80)
            }
        }

        When("the player throws a 'spare'") {
            val game = Bowling()
            game.roll(6)
            game.roll(4)
            game.roll(8)
            game.roll(1)
            Then("score is incremented by next ball") {
                game.getScore().shouldBe(10 + 8 + 8 +1)
            }
        }

        When("the player throws a 'strike'") {
            val game = Bowling()
            game.roll(10)
            game.roll(7)
            game.roll(1)
            Then("score is incremented by next two balls") {
                game.getScore().shouldBe(18 + 8)
            }
        }

        When("the player rolls strike 10 times and 2 extra"){
            val game = Bowling()
            repeat(12, { game.roll(10) })
            Then("score is 300") {
                game.getScore().shouldBe(300)
            }
        }
    }
})