{-# LANGUAGE ViewPatterns #-}

import qualified Data.Sequence as Sq
import Data.Array
import qualified Data.Map.Strict as M
import Data.Sequence ((><), (<|))
import Data.List (intercalate)
import Data.Bits ((.&.))

type Graph = M.Map Int [Int]

samePart :: Int -> Int -> Bool
samePart a_i a_j = (a_i .&. 1) == (a_j .&. 1)

buildGraph :: Array Int Int -> [(Int, Int)] -> Graph
buildGraph arr xsIndexed = M.fromListWith (++) pairs where
    n = (snd . bounds) arr
    pairs = filter (\(k, _) -> k /= 1) $ concat [getEdges i a_i | (i, a_i) <- xsIndexed]
    getEdges i a_i = if  loValid &&  hiValid then [(lo, [i]), (hi, [i])]
            else if loValid then [(lo, [i])]
            else if hiValid then [(hi, [i])]
            else [(-1, [i])] 
            where
                lo = i - a_i
                hi = i + a_i
                loValid = lo >= 1 && samePart a_i (arr ! lo)
                hiValid = hi <= n && samePart a_i (arr ! hi)

bfs :: Array Int Int -> Graph -> Array Int Int
bfs arr graph = go initialQueue ans where
    n = (snd . bounds) arr
    ans = array (1, n) [(i, checkNeighbors i (arr ! i)) | i <- [1..n]]
    initialQueue = Sq.fromList [i | i <- indices ans, ans ! i == 1]

    checkNeighbors i a_i = if loValid || hiValid then 1 else -1 where
        lo = i - a_i
        hi = i + a_i
        loValid = lo >= 1 && (not $ samePart a_i (arr ! lo))
        hiValid = hi <= n && (not $ samePart a_i (arr ! hi))

    go :: Sq.Seq Int -> Array Int Int -> Array Int Int
    go queue acc =
        case Sq.viewl queue of
            Sq.EmptyL -> acc
            v Sq.:< vs -> go queue' acc' where
                    neighbors = M.findWithDefault [] v graph
                    validNg = [u | u <- neighbors, acc ! u == -1]
                    queue' = vs >< Sq.fromList validNg
                    acc' = acc // [(ng, 1 + acc ! v) | ng <- validNg]

getNearestSteps :: Int -> [Int] -> String
getNearestSteps n xs = (intercalate " " . map show . elems) ans where
    indices = [1..n]
    xsIndexed = zip [1..n] xs
    arr = array (1, n) xsIndexed
    graph = buildGraph arr xsIndexed
    ans = bfs arr graph

main =
    read <$> getLine >>= \n ->
    (map read) . words <$> getLine >>= \xs ->
    putStrLn $ getNearestSteps n xs