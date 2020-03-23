package com.kata.tdd.bowling

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec

class BowlingSpec : BehaviorSpec({

    lateinit var game: Bowling

    Given("a bowling game") {
        When("not all pins are down in each frame") {
            game = Bowling()
            repeat(20, { game.roll(4) })
            val score = game.getScore()
            Then("score is sum of pins down") {
                score.shouldBe(80)
            }
        }
    }
})