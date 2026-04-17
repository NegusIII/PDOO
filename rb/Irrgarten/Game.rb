#encoding:UTF-8

module Irrgarten
    class Game

        MAX_ROUNDS=10

        def initialize(n_players)
            dado = Dice.new

            @log=""
            @labyrinth = Labyrinth.new(4,4,2,3)
            @players = Array.new
            @monsters = Array.new

            n_players.times do |i|
                actual = Player.new(i, dado.random_intelligence, dado.random_strength)
                @players << actual
            end
            @current_player_index=dado.who_starts(n_players)
            @current_player=@players[@current_player_index]

            configure_labyrinth
            #@labyrinth.spread_players(@players)
        end

        def finished
            return @labyrinth.have_a_winner
        end

        def next_step(preferred_direction)
            log = ""
            boolean dead = @current_player.dead
            if (!dead)
                direction = actual_direction(preferred_direction)
                if (direction != preferred_direction)
                    log_player_no_orders
                end
                monster = @labyrinth.put_player(direction, @current_player)
                if (monster == nil)
                    log_no_monster
                else
                    winner = combat(monster)
                    manage_reward(winner)
                end
            else
                manage_resurrection
            end
            end_game=finished
            if (!end_game)
                next_player
            end
            end_game
        end

        def get_game_state

            laberinto = @labyrinth.to_string
            jugadores = @players.map { |p| p.to_s }.join("\n")
            monstruos = @monsters.map { |m| m.to_s }.join("\n")
            estado = GameState.new(laberinto, jugadores, monstruos, @current_player, finished, @log)

            return estado
        end


        private


        def configure_labyrinth
            dado = Dice.new
            monstruo1 = Monster.new("Netanyahu", dado.random_intelligence, dado.random_strength)
            monstruo2 = Monster.new("Bin Laden", dado.random_intelligence, dado.random_strength)
            monstruo3 = Monster.new("Khamenei", dado.random_intelligence, dado.random_strength)

            @labyrinth.add_monster(3,3,monstruo1)
            @labyrinth.add_monster(3,1,monstruo2)
            @labyrinth.add_monster(3,0,monstruo3)
            
        end

        def next_player 
            if (@current_player_index==@players.size-1)
                @current_player_index=0
            else
                @current_player_index+=1
            end

            @current_player = @players[@current_player_index]
        end

        def actual_direction(preferredDirection)
            current_row=@current_player.get_row()
            current_col=@current_player.get_col()

            valid_moves = labyrinth.valid_moves(current_row,current_col)
            output = move(preferredDirection,valid_moves)
            output
        end

        def combat(monster)
            rounds = 0
            winner = GameCharacter::PLAYER

            player_attack=@current_player.attack
            lose = monster.defend(player_attack)

            while (!lose && rounds < MAX_ROUNDS) do
                rounds+=1
                winner=GameCharacter::MONSTER
                monster_attack=monster.attack
                lose = @current_player.defend(monster_attack)

                if (!lose)
                    winner=GameCharacter::PLAYER
                    player_attack=@current_player.attack
                    lose = monster.defend(player_attack)
                end
            end
            log_rounds
            winner
        end

        def manage_reward(winner)
            if (winner==GameCharacter::PLAYER)
                @current_player.receive_reward
                log_player_won
            else
                log_monster_won
            end
        end

        def manage_resurrection
            dado = Dice.new
            resurrect = dado.resurrect_player
            if (resurrect)
                @current_player.resurrect
                log_resurrected
            else
                log_player_skip_turn
            end
        end

        def log_player_won
            @log+="El jugador ha ganado el combate\n";
        end

        def log_monster_won
            @log+="El monstruo ha ganado el combate\n";
        end

        def log_resurrected
            @log+="El jugador ha resucitado\n";
        end

        def log_player_skip_turn
            @log+="El jugador ha perdido su turno por estar muerto\n";
        end

        def log_player_no_orders
            @log+="El jugador no ha podido cumplir las órdenes\n";
        end

        def log_no_monster
            @log+="El jugador se ha movido a una celda vacía o no le ha sido posible moverse\n";
        end

        def log_rounds(rounds,max)
            log+="Se han producido #{rounds} de #{max} rondas de combate\n"
        end

    end
end