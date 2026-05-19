#encoding:UTF-8
require_relative'LabyrinthCharacter'

module Irrgarten
    class Monster < LabyrinthCharacter
        @@INITIAL_HEALTH=5.0

        def initialize(name, intelligence, strength)
            super(name,intelligence,strength,@@INITIAL_HEALTH)
        end
        
        def attack
            return Dice.intensity(@strength)
        end

        def defend(received_attack)
            is_dead = dead?
            if (!is_dead)
                defensive_energy = Dice.intensity(@intelligence)
                if (defensive_energy < received_attack)
                    got_wounded
                    is_dead = dead?
                end
            end
            is_dead
        end

        def to_s
            super
        end

        private

        def got_wounded
            @health-=1
        end
    end
end