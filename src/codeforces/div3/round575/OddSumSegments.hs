import Control.Monad (replicateM_)

findSegments :: Int -> Int -> [Int] -> [Int]
findSegments n k xs
    | numOdds < k || (numOdds - k) `mod` 2 == 1 = []
    | otherwise = (take (k - 1) $ map snd odds) ++ [n]
    where 
        odds = filter (\(x, _) -> x `mod` 2 == 1) (zip xs [1..n])
        numOdds = length odds

readLine :: IO [Int]
readLine = (map read) . words <$> getLine

main =
    read <$> getLine >>= \q ->
    replicateM_ q (
        readLine >>= \[n, k] ->
        readLine >>= \xs ->
        putStrLn(
            let ans = findSegments n k xs in
                if null ans then "NO"
                else "YES\n" ++ unwords (map show ans)
        )
    )