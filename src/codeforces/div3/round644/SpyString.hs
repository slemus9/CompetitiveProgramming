import Control.Monad (replicateM, replicateM_)

readSizes :: IO [Int]
readSizes = (map read) . words <$> getLine

readStrings :: IO [String]
readStrings = readSizes >>= \ [n, _] -> 
     replicateM n getLine

are1CharAway :: String -> String -> Bool
are1CharAway s1 s2 = foldl accumulate 0 (zip s1 s2) <= 1
    where
        accumulate = \ acc (c1, c2) -> acc + if c1 == c2 then 0 else 1

checkString :: String -> [String] -> Bool
checkString s ss = all (are1CharAway s) ss

replaceChar :: Int -> Char -> String -> String
replaceChar idx c xs = [if idx == i then c else x | (x, i) <- zip xs [0..]]

permutateString :: String -> [String]
permutateString xs = [replaceChar idx c xs | idx <- [0..m], c <- enumFromTo 'a' 'z']
    where m = length xs - 1

solve :: [String] -> String
solve xss = if length ans > 0 then head ans else "-1"
    where
        template = head xss
        ans = filter (\xs -> checkString xs xss) (permutateString template)

main =
    read <$> getLine >>= \t ->
    replicateM_ t (
        readStrings >>= \xss ->
        putStrLn $ solve xss
    )