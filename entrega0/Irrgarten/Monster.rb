#encoding:UTF-8

module Irrgarten
    class Monster
        INITIAL_HEALTH=5.0
        INVALID_POS=-1

        def initialize(name, intelligence, strength)
            @name=name
            @intelligence=intelligence
            @strength=strength
            @health=INITIAL_HEALTH
            @row=@col=INVALID_POS
        end

        def dead
            return @health==0
        end
        
        def attack
            return Dice.intensity(@strength)
        end

        def defend(received_attack)
            is_dead = dead
            if (!is_dead)
                defensive_energy = Dice.intensity(@intelligence)
                if (defensive_energy < received_attack)
                    got_wounded
                    is_dead = dead
                end
            end
            is_dead
        end

        def set_pos(row, col)
            @row=row
            @col=col
        end

        def to_s
            "M[#{@name}: I#{@intelligence}, S#{@strength}, H#{@health}, P(#{@row},#{@col})]"
        end

        private

        def got_wounded
            @health-=1
        end
    end
end