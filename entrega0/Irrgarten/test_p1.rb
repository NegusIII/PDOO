# encoding: utf-8

require_relative 'GameState'
require_relative 'Dice'
require_relative 'Weapon'
require_relative 'Shield'
require_relative 'Directions'
require_relative 'GameCharacter'
require_relative 'Orientation'

module Irrgarten
  class TestP1
    def self.main
      # Índice de pruebas
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      
      puts "Pruebas:"
      puts "1-Clase Gamestate\n2-Clase Dice\n3-Clases Weapon y Shield\n4-Structs\n\n"
      
      # Prueba del GameState
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      
      puts "1- Clase GameState:\n\n"
      
      estado = GameState.new("Namibia", "No hay jugadores", "No hay monstruos", 0, false, "No ha ocurrido nada")
      
      puts "Labyrinth: #{estado.get_labyrinth}"
      puts "Players: #{estado.get_players}"
      puts "Monsters: #{estado.get_monsters}"
      puts "Current Player: #{estado.get_current_player}"
      puts "Winner? #{estado.get_winner}"
      puts "Log: #{estado.get_log}\n\n"
      
      # Prueba de la clase Dice
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      puts "2- Clase Dice:\n\n"
      dado = Dice.new
      
      puts "Posiciones aleatorias [0,9]:"
      num = 10
      (0...num).each do |i|
        if i == num - 1
          print "#{dado.random_pos(10)}\n\n"
        else
          print "#{dado.random_pos(10)}, "
        end
      end
      
      puts "Fuerza de un arma aleatoria (hasta 10):"
      (0...num).each do |i|
        if i == num - 1
          print "#{dado.random_strength}\n\n"
        else
          print "#{dado.random_strength}, "
        end
      end
      
      puts "Intentos de resurrección de un jugador:"
      (0...num).each do |i|
        if i == num - 1
          print "#{dado.resurrect_player}\n"
        else
          print "#{dado.resurrect_player}, "
        end
      end
      
      exitos = 0
      intentos = 1_000_000
      
      intentos.times do
        if dado.resurrect_player
          exitos += 1
        end
      end
      
      p = exitos.to_f / intentos
      
      puts "Tras #{intentos} intentos, la probabilidad calculada de resurrección es de: #{p}\n\n"
      
      puts "Descartar elementos:"
      
      (0...num).each do |i|
        usos = dado.uses_left
        puts "Usos: #{usos}/5. Descartado: #{dado.discard_element(usos)}"
      end
      
      # Prueba de las clases Weapon y Shield
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      puts "3- Clases Weapon y Shield:\n\n"
      
      puts "Generación de armas y escudos:"
      (0...num).each do |i|
        w = Weapon.new(dado.weapon_power, dado.uses_left)
        if i == num - 1
          print "#{w.to_s}\n"
        else
          print "#{w.to_s}, "
        end
      end
      
      (0...num).each do |i|
        s = Shield.new(dado.shield_power, dado.uses_left)
        if i == num - 1
          print "#{s.to_s}\n\n"
        else
          print "#{s.to_s}, "
        end
      end
      
      puts "Descartar armas y escudos:\n\n"
      
      # Prueba de los Structs
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
      puts "4- Structs:\n\n"
      
      # Fin de las pruebas
      puts "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n\n"
    end
  end
end

Irrgarten::TestP1.main