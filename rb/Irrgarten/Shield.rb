#encoding:utf-8

module Irrgarten
    class Shield
        @protection
        @uses

        def initialize(protection, uses)
            @protection = protection
            @uses = uses
        end

        def attack
            if @uses > 0
                uses-=1
                return @protection
            
            else
                return 0
            end
        end

        def to_s
            "S[#{@protection},#{@uses}]"
        end

        
    end
end