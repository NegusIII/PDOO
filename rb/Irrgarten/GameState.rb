#encoding:utf-8

module Irrgarten
    class GameState

        @labyrinth
        @players
        @monsters
        @currentPlayer
        @winner
        @log

        def initialize(labyrinth, players, monsters, currentPlayer, winner, log)
            @labyrinth = labyrinth
            @players = players
            @monsters = monsters
            @currentPlayer = currentPlayer
            @winner = winner
            @log = log
        end

        def get_labyrinth
            return @labyrinth
        end

        def get_players
            return @players
        end

        def get_monsters
            return @monsters
        end

        def get_current_player
            return @currentPlayer
        end

        def get_winner
            return @winner
        end

        def get_log
            return @log
        end
    end
end