Repozytorium zawiera rozwiązanie zadania rekrutacyjnego, polegającego na zaimplementowaniu 3 metod z interfejsu Structure: findBlockByColor, findBlocksByMaterial, count w klasie Wall. 

Implementacja interfejsu CompositeBlock dodaje możliwość zawarcia w liście blocks w klasie Wall nie tylko interfejsu Block, ale również CompositeBlocks który to może posiadać w sobie kolejną listę bloków. Sytuacja ta wymaga sprawdzenia typu każdego z przetwarzanych bloków, znajdujących się we wcześniej wspomnianej liście blocks. Za pomocą instanceof rozwiązano ten problem, oraz zaimplementowano poprawne przetwarzanie obu rodzajów bloków.