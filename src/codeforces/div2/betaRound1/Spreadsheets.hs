import Control.Monad
import Data.Char
import Data.Sequence (Seq, empty, (|>))
import Data.Foldable (toList)

parseRowColFormat :: String -> Maybe (Int, Int)
parseRowColFormat s@(x : _) = if x == 'R' then go "" "" s else Nothing where
    go "" "" [] = Nothing
    go (r:rs) "" [] = Nothing
    go rows@(r:rs) "" (_: xs) = go rows xs []
    go rows@(r:rs) cols@(c:cs) [] = Just (read rows, read cols)
    go "" "" (_ : xs) = go (takeWhile isDigit xs) "" (dropWhile isDigit xs)

parseStandartFormat :: String -> Maybe (String, Int)
parseStandartFormat s = go "" "" s where
    go "" "" [] = Nothing
    go (c:cs) "" [] = Nothing
    go cols@(c:cs) "" xss@(x:xs) = if any isAlpha xss then Nothing else go cols xss []
    go cols@(c:cs) rows@(r:rs) [] = Just (cols, read rows)
    go "" "" xs = go (takeWhile isAlpha xs) "" (dropWhile isAlpha xs)

col2Alpha :: Int -> String
col2Alpha = toList . go where
    go 0 = empty
    go col = go ((col - 1) `div` 26) |> chr((col - 1) `mod` 26 + ord('A'))

alpha2Col :: String -> Int
alpha2Col col = foldl (\acc c -> acc*26 + ord(c) - ord('A') + 1) 0 col

parse :: String -> String
parse format = case parseRowColFormat format of
    Just (row, col) -> col2Alpha col ++ show row
    Nothing -> case parseStandartFormat format of
        Just (scol, srow) -> ('R' : show srow) ++ ('C' : (show $ alpha2Col scol))
        Nothing -> ""

main =
    read <$> getLine >>= \n -> 
    replicateM_ n (parse <$> getLine >>= putStrLn)