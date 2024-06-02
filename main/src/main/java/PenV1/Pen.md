
### Design a pen
* Requirements
* A pen is anything that can write.
* Pen can be Gel, Ball, Fountain, Marker.
* Ball Pen and Gel Pen have a Ball Pen Refill and a Gel Pen Refill respectively to write.
* A refil has a tip and an ink.
* Ink can be of different colour
* A fountain pen has an Ink.
* Refill has a radius.
* For fountain pen, its tip has a radius.
* Each pen can write in a different way.
* Some pens write in the same way.
* Every pen has a brand and a name.
* Some pens may allow refilling while others might not.
# Entities and Attributes.
# Pen
 * Brand
 * Name
* Type (Gel, Ball, Fountain, Marker)
* Price
* Refill
* Type (Ball, Gel)
* Ink
* Nib
* Ink
* Colour
* Brand
Type (Gel, Ball, Fountain)
Nib
Radius
Type (Fountain, Ball, Gel)
Different types of pens
Gel Pen

Type - Gel
Refill
Type - Gel
Nib - Gel
Ink
Type - Gel
Refillable - Yes
Ball Pen

Type - Ball
Refill
Type - Ball
Nib - Ball
Ink
Type - Ball
Refillable - Yes
Throwaway Pen

Type - Throwaway
Refill
Type - Ball
Nib - Ball
Ink
Type - Ball
Refillable - No
Fountain Pen

Type - Fountain
Ink
Type - Fountain
NiB
Type - Fountain

```mermaid
classDiagram
    Pen "*" --o "1" PenType
    Pen "1" --* "1" Refill
    Pen "1"--* "1"Ink
    Pen "1" --* "1" Nib
    
    
    Refill "*" --* "1" RefillType
    Refill "1"--* "1" Ink
    
    Refill "1" --* "1"Nib
    Ink "*" --o "1" InkType
    
    class Pen{
        
        -String name
        -String brand
        -PenType type
        -WritingStrategy writingStrategy
        -boolean isRefillable
        -Refill refill
        -Ink ink
        -Nib nib
        +write() void 
        +changeRefill(Refill) void
    }
    
    class Refill {
        -Ink ink
        -Nib nib
        -RefillType type
    }
    class RefillType{
        <<Enumeration>>
        GEL
        BALL
    }
    class Nib{ 
        -int raduis
   }
   class Ink{
       -String color
       -String brand
       -InkType type
   }
   class InkType{
       <<Enumeration>>
       GEL
       BALL 
       FOUNTAIN
   }
   class PenType {
       <<Enumeration>>
       BALL 
       GELL
       FOUNTAIN
       USE_AND_THROW
   } 
```

## Optimised design


```mermaid
classDiagram
%%    Pen "*" --o "1" PenType
%%    Pen "1" --* "1" Refill
%%    Pen "1"--* "1"Ink
%%    Pen "1" --* "1" Nib
%%    
%%    
%%    Refill "*" --* "1" RefillType
%%    Refill "1"--* "1" Ink
%%    
%%    Refill "1" --* "1"Nib
%%    Ink "*" --o "1" InkType
    
    class Pen{
        <<abstract>>
        -String name
        -String brand
        -PenType type
        -WritingStrategy writingStrategy
        -boolean isRefillable
        +write()* void 
        +changeRefill(Refill)* void
    }
    class GelPen {
        -Refill refill
        +write() void
        +changeRefill() void
    }
    class FountainPen {
        -Ink ink
        -Nib nib
        +write() void
        +changeRefill() void
    }
    class BallPen {
        -RefillType type
        +write() void
        +changeRefill() void
    }
    
    class Refill {
        -Ink ink
        -Nib nib
        -RefillType type
    }

    class Nib{ 
        -double raduis
   }
   class Ink{
       -String color
       -String brand
       -InkType type
   }

   Pen <|-- FountainPen
   Pen <|-- GelPen
   Pen <|-- BallPen

   

   Refill -- o Nib

   
   FountainPen  --*  Nib
   FountainPen  --*  Ink
    
   BallPen --* Refill 
   GelPen --* Refill
```

# Reducing code duplication using strategy design patter
1. Create strategy interface 
2. create concrete strategies and 
3. Compose a pen class with strategy

```mermaid
classDiagram
    
    class Pen {
        <<abstract>>
        -String name
        -String brand
        -PenType type
        -WritingStrategy writingStrategy
        -boolean isRefillable
        -WritingStrategy writeStrategy
        +write() void
        +changeRefill(Refill)* void
    }
    class WritingStrategy{
        <<interface>>
        void write()
    }
    class SmoothWritingStrategy{
        +void write()
    }
    class RoughWritingStrategy{
        +void write()
    }
    WritingStrategy <|-- SmoothWritingStrategy
    WritingStrategy <|-- RoughWritingStrategy
    
    Pen"*" --o "1"WritingStrategy
```