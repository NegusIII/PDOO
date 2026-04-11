#encoding:UTF-8

module Irrgarten
    class Labyrinth
        BLOCK_CHAR='X'
        EMPTY_CHAR='-'
        MONSTER_CHAR='M'
        COMBAT_CHAR='C'
        EXIT_CHAR='E'
        ROW=0
        COL=1

        def initialize(n_rows, n_cols, exit_row, exit_col)
            @n_rows=n_rows
            @n_cols=n_cols
            @exit_row=exit_row
            @exit_col=exit_col

            @monsters = Array.new(n_rows) { Array.new(n_cols) }
            @players = Array.new(n_rows) { Array.new(n_cols) }
            @labyrinth = Array.new(n_rows) { Array.new(n_cols, '-') }

            @labyrinth[@exit_row][@exit_col]='E'
        end

        def spread_players
        end

        def have_a_winner
            return @players[@exit_row][@exit_col]!=nil
        end

        def to_string

            s=""

            @n_rows.times do |i|
                @n_cols.times do |j|
                    s+= "#{@labyrinth[i][j]} "
                end
                s+="\n"
            end
            return s
        end

        def add_monster(row,col,monster)
            if(pos_ok(row,col))
                @labyrinth[row][col]=MONSTER_CHAR
                @monsters[row][col]=monster
                monster.set_pos(row,col)
            end
        end

        def put_player(direction,player)
        end

        def add_block(orientation, start_row, start_col)
        end

        def valid_moves(row,col)
        end


        private


        def pos_ok(row,col)
            return (0 <= row && row < @n_rows && 0 <= col && col < @n_cols)
        end

        def empty_pos(row,col)
            return @labyrinth[row][col]==EMPTY_CHAR;
        end

        def monster_pos(row,col)
            return @labyrinth[row][col]==MONSTER_CHAR;
        end

        def exit_pos(row,col)
            return @labyrinth[row][col]==EXIT_CHAR;
        end

        def combat_pos(row,col)
            return @labyrinth[row][col]==COMBAT_CHAR;
        end

        def can_step_on(row,col)
            return (pos_ok(row,col)&&(monster_pos(row, col)||exit_pos(row,col)||combat_pos(row,col)))
        end

        def update_old_pos(row,col)
            if (pos_ok(row,col))
                if(combat_pos(row,col))
                    @labyrinth[row][col]=MONSTER_CHAR
                else
                    @labyrinth[row][col]=EMPTY_CHAR
                end
            end
        end

        def dir_2_pos(row,col,direction)

            case direction
            when Directions::LEFT
                return [row, col - 1]
            when Directions::RIGHT
                return [row, col + 1]
            when Directions::UP
                return [row - 1, col]
            when Directions::DOWN
                return [row + 1, col]
            end
        end

        def random_empty_pos
            empty=false
            dado =Dice.new
            pos={0,0}

            while (empty==false) do
                pos[ROW]=dado.random_pos(n_rows)
                pos[COL]=dado.random_pos(n_cols)
                empty=empty_pos(pos[ROW],pos[COL])
            end
            return pos
        end

        def put_player_2d(old_row,old_col,row,col,player)
        end
    end
end