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
            dado = Dice.new
            return dado.intensity(@strength)
        end

        def defend
        end

        def set_pos(row, col)
            @row=row
            @col=col
        end

        def to_string
            "M[#{@name}: I#{@intelligence}, S#{@strength}, H#{@health}, P(#{@row},#{@col})]"
        end

        private

        def got_wounded
            @health-=1
        end
    end
end