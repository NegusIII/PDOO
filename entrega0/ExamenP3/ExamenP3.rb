#encoding:UTF-8
require_relative '../Irrgarten/Game'
require_relative '../UI/textUI'
require_relative '../Control/controller'

module Prueba
    class ExamenP3
    @@NUM_JUGADORES=2
        def self.main
          game = Irrgarten::Game.new(@@NUM_JUGADORES)
          view = UI::TextUI.new
          controller = Control::Controller.new(game, view)
          controller.play
        end
    end
end
Prueba::ExamenP3.main
