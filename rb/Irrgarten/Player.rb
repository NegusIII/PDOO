#encoding:UTF-8
require_relative'Dice'
require_relative'Weapon'
require_relative'Shield'

module Irrgarten
    class Player
        
        @@MAX_WEAPONS=2
        @@MAX_SHIELDS=2
        @@INITIAL_HEALTH=10
        @@HITS2LOSE=3

        def initialize(number, intelligence, strength)
            @weapons = Array.new
            @shields = Array.new

            @number=number
            @intelligence=intelligence
            @strength=strength
            @health=@@INITIAL_HEALTH
            @row
            @col
            @consecutive_hits=0

            @name="Player ##{@number}"
        end

        def resurrect
            @health=@@INITIAL_HEALTH
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

        def move(direction, valid_moves)
            size = valid_moves.size
            contained = valid_moves.include?(direction)
            if (size > 0 && !contained)
                first_element=valid_moves[0]
                return first_element
            else return direction
            end
        end


        def attack
            return @strength + sum_weapon
        end

        def defend(received_attack)
        end

        def receive_reward
            w_reward = Dice.weapons_reward
            s_reward = Dice.shields_reward

            w_reward.times do 
                wnew = self.new_weapon
                self.receive_weapon(wnew)
            end
            s_reward.times do
                snew = self.new_shield
                self.receive_shield(snew)
            end
            extra_health = Dice.health_reward
            @health += extra_health
        end

        def to_s
            string="P[#{@name}: I#{@intelligence}, S#{@strength}, H#{@health}, Ch#{@consecutive_hits}, P(#{@row},#{@col})]"
        end


        private


        def receive_weapon(w)
            @weapons.delete_if{|wi| wi.discard}
            if (@weapons.size < @@MAX_WEAPONS)
                @weapons << w
            end
            
        end

        def receive_shield(s)
            @shields.delete_if{|si| si.discard}
            if (@shields.size < @@MAX_SHIELDS)
                @shields << s
            end
        end

        def new_weapon
            return Weapon.new(Dice.weapon_power, Dice.uses_left)
        end

        def new_shield
            return Shield.new(Dice.shield_power, Dice.uses_left)
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
            defense = self.defensive_energy
            if (defense < received_attack)
                got_wounded
                inc_consecutive_hits
            else
                reset_hits
            end
            if (consecutive_hits==@@HITS2LOSE || self.dead)
                lose=true
            else lose = false
            end
            lose
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