#encoding:utf-8

module Irrgarten
    class Dice
        @@MAX_USES=5
        @@MAX_INTELLIGENCE=10.0
        @@MAX_STRENGHT=10.0
        @@RESURRECT_PROB=0.3
        @@WEAPONS_REWARD=2
        @@SHIELDS_REWARD=3
        @@HEALTH_REWARD=5
        @@MAX_ATTACK=3
        @@MAX_SHIELD=2

        @@generator = Random.new

        def random_pos(max)
            return @@generator.rand(max)
        end

        def who_starts(nplayers)
            return @@generator.rand(nplayers)
        end

        def random_intelligence
            return @@generator.rand(@@MAX_INTELLIGENCE)
        end
        
        def random_strength
            return @@generator.rand(@@MAX_STRENGHT)
        end

        def resurrect_player
            return (@@generator.rand()<=@@RESURRECT_PROB)
        end

        def weapons_reward
            return @@generator.rand(@@WEAPONS_REWARD)
        end

        def shields_reward
            return @@generator.rand(@@SHIELDS_REWARD)
        end

        def health_reward
            return @@generator.rand(@@HEALTH_REWARD)
        end

        def weapon_power
            return @@generator.rand(@@MAX_ATTACK)
        end

        def shield_power
            return @@generator.rand(@@MAX_SHIELD)
        end

        def uses_left()
            return @@generator.rand(@@MAX_USES)
        end

        def intensity(competence)
            return @@generator.rand(competence)
        end

        def discard_element(uses_left)
            return (@@generator.rand()>uses_left.to_f/@@MAX_USES)
        end
    end
end