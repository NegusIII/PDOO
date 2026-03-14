#encoding:utf-8

module Irrgarten
    class Weapon
        @power
        @uses

        def initialize(power, uses)
            @power = power
            @uses = uses
        end

        def attack
            if @uses > 0
                uses-=1
                return @power
            
            else
                return 0
            end
        end

        def to_s
            "W[#{@power},#{@uses}]"
        end

        
    end