#encoding:UTF-8

module Irrgarten
    class Player
        
        MAX_WEAPONS=2
        MAX_SHIELDS=2
        INITIAL_HEALTH=10
        HITS2LOSE=3

        def initialize(number, intelligence, strength)
            @weapons = Array.new
            @shields = Array.new

            @number=number
            @intelligence=intelligence
            @strength=strength
            @health=INITIAL_HEALTH
            @row
            @col
            @consecutive_hits=0

            @name="Player ##{@number}"
        end

        def resurrect
            @health=INITIAL_HEALTH
            @weapons = []
            @shields = []
            reset_hits
        end

        def get_row
            return @row
        end
        
        def get_col
            return @col
        end

        def get_number
            return @number
        end

        def set_pos(row,col)
            @row=row
            @col=col
        end

        def dead
            return @health==0.0
        end

        def move
        end


        def attack
            return @strength + sum_weapon
        end

        def defend(received_attack)
        end

        def receive_reward

        end

        def to_string
            "P[#{@name}: I#{@intelligence}, S#{@strength}, H#{@health}, Ch#{@consecutive_hits}, P(#{@row},#{@col})]"
        end


        private


        def receive_weapon
        end

        def receive_shield
        end

        def new_weapon
            dado = Dice.new
            return Weapon.new(dado.weapon_power, dado.uses_left)
        end

        def new_shield
            dado = Dice.new
            return Shield.new(dado.shield_power, dado.uses_left)
        end

        def sum_weapon
            suma=0.0

            @weapons.each do |w|
                suma += w.attack
            end
            return suma
        end

        def sum_shield
            suma=0.0

            @shields.each do |s|
                suma += s.protect
            end
            return suma
        end

        def defensive_energy
            return @intelligence+sum_shield
        end

        def manage_hit(received_attack)

        end

        def reset_hits
            @consecutive_hits=0
        end

        def got_wounded
            @health-=1
        end

        def inc_consecutive_hits
            @consecutive_hits+=1
        end
    end
end