# encoding: utf-8

require_relative 'GameState'
require_relative 'Dice'
require_relative 'Weapon'
require_relative 'Shield'
require_relative 'Directions'
require_relative 'GameCharacter'
require_relative 'Orientation'
require_relative 'Monster'
require_relative 'Player'
require_relative 'Labyrinth'
require_relative 'Game'

module Irrgarten
  class TestP2
    def self.main
      
      # Índice de pruebas
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      
      puts "Pruebas Práctica 2:"
      puts "1-Clase Monster\n2-Clase Player\n3-Clase Labyrinth\n4-Clase Game\n\n"
      
      # Prueba de la clase Monster
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      puts "1- Clase Monster:\n\n"
      
      netanyahu = Monster.new("Netanyahu", 7.0, 4.0)
      netanyahu.set_pos(2, 3)
      
      puts "Estado inicial: #{netanyahu.to_string}"
      puts "Fuerza de ataque generada: #{netanyahu.attack}"
      puts "¿Defiende bien (daño 2.0)?: #{netanyahu.defend}"
      puts "¿Está muerto?: #{netanyahu.dead}\n\n"

      # Prueba de la clase Player
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      puts "2- Clase Player:\n\n"
      
      khamenei = Player.new('1', 5.0, 6.0)
      khamenei.set_pos(0, 0)
      
      puts "Estado inicial: #{khamenei.to_string}"
      puts "Fila: #{khamenei.get_row}, Columna: #{khamenei.get_col}"
      puts "Identificador (Number): #{khamenei.get_number}"
      puts "Ataque base (sin armas sumadas): #{khamenei.attack}"
      puts "¿Está muerto?: #{khamenei.dead}\n\n"

      # Prueba de la clase Labyrinth
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      puts "3- Clase Labyrinth:\n\n"
      
      tel_aviv = Labyrinth.new(5, 5, 4, 4)
      tel_aviv.add_monster(2, 3, netanyahu)
      
      puts "¿Tenemos un ganador?: #{tel_aviv.have_a_winner}"
      puts "Mapa Visual del Terreno:\n#{tel_aviv.to_string}\n\n"

      # Prueba de la clase Game
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      puts "4- Clase Game:\n\n"
      
      partida = Game.new(2)
      
      puts "¿Partida terminada?: #{partida.finished}"
      
      estado = partida.get_game_state
      puts "Registro de Eventos (Log):\n#{estado.get_log}"
      puts "Tropas Enemigas Desplegadas:\n#{estado.get_monsters}\n\n"

      # Fin de las pruebas
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      
    end
  end
end

# Ejecución de la rutina principal
Irrgarten::TestP2.main