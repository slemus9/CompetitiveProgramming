{-# LANGUAGE ViewPatterns #-}

import qualified Data.Map.Strict as M
import qualified Data.Set as S
import qualified Data.Sequence as Sq
import Data.Sequence ((><), (<|))


type Graph = M.Map Int [Int]

buildGraph :: Int -> [Int] -> Graph
buildGraph n xs = M.fromList pairs where
    pairs = foldr (\(i, a_i) acc -> edges i a_i : acc) [] (zip [1..n] xs)
    edges i a_i = (i, vs) where 
        vs = if i - a_i >= 1 && i + a_i <= n then [i - a_i, i + a_i]
            else if i - a_i >= 1 then [i - a_i]
            else if i + a_i <= n then [i + a_i]
            else []
    

bfs :: Graph -> Int -> [Int]
bfs graph src = go S.empty (Sq.singleton src) where
    go :: S.Set Int -> Sq.Seq Int -> [Int]
    go visited queue =
        case Sq.viewl queue of
            Sq.EmptyL -> []
            v Sq.:< vs -> v : (go visited' queue') where
                neighbors = filter (\u -> not $ S.member u visited) (graph M.! v)
                visited' = S.insert v visited
                queue' = vs >< Sq.fromList neighbors
