#encoding:utf-8
require_relative 'Player'
module Irrgarten
    class FuzzyPlayer < Player
        def initialize(other)
            copy(other)
        end

        def move(direction, valid_moves)
            Dice.next_step(super(direction,valid_moves),valid_moves, @intelligence)
        end

        def attack
            Dice.intensity(@intelligence+sum_weapon)
        end

        def to_s
            "Fuzzy"+super
        end

        protected

        def defensive_energy
            Dice.intensity(@intelligence+sum_shield)
        end
    end
end