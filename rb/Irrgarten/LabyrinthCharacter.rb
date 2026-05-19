#encoding:utf-8
module Irrgarten
    class LabyrinthCharacter

        attr_reader :name, :row, :col, :intelligence, :strength, :health

        @@INVALID_POS=-1

        def initialize(name, intelligence, strength, health)
            @name=name
            @intelligence=intelligence
            @strength=strength
            @health=health
            @row=@col=@@INVALID_POS
        end

        def copy (other)
            @name=other.name
            @intelligence=other.intelligence
            @health=other.health
            @row=other.row
            @col=other.col
        end

        def dead?
            return @health==0.0
        end

        def get_row
            @row
        end

        def get_col
            @col
        end

        def set_pos(row,col)
            @row=row
            @col=col
        end

        def to_s
            "#{@name} [I:#{@intelligence}, S:#{@strength}, H:#{@health}, P(#{@row},#{@col})]"
        end

        def attack
        end

        def defend
        end

        protected

        def get_intelligence
            @intelligence
        end

        def get_strength
            @strength
        end

        def get_health
            @health
        end

        def set_health(health)
            @health=health
        end

        def got_wounded
            @health-=1
        end
    end
end