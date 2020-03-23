package com.kata.tdd.bowling

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec

class BowlingSpec : BehaviorSpec({

    Given("a bowling game") {

        //lateinit var game: Bowling

        When("not all pins are down in each frame") {
            val game = Bowling()
            repeat(20, { game.roll(4) })
            Then("score is sum of pins down") {
                game.getScore().shouldBe(80)
            }
        }

        When("the player throws after a 'spare'"){
            val game = Bowling()
            game.roll(1)
            game.roll(9)
            game.roll(7)
            Then("score is incremented by 10"){
                game.getScore().shouldBe(1 + 9 + 10 + 7)
            }
        }
    }
})