dist :: ((Double, Double), (Double, Double)) -> Double
dist ((x1, y1), (x2, y2)) = sqrt ((x1 - x2)^2 + (y1 - y2)^2)

findAngle :: (Double, Double, Double) -> Double
findAngle (a, b, c) = acos ((b^2 + c^2 - a^2) / (2*b*c) )

fgcd :: Double -> Double -> Double
fgcd a b 
    | abs a < e || abs b < e = a + b
    | a > b = fgcd (step a b) b
    | otherwise = fgcd a (step b a)
    where 
        e = 1e-4
        step x y = x - y * (fromIntegral $ floor (x / y))

findArea :: [[Double]] -> Double
findArea points = (n/2) * r^2 * sin (2*pi/n) where
    [p1, p2, p3] = map (\[p_x, p_y] -> (p_x, p_y)) points
    [a, b, c] = map dist [(p1, p2), (p2, p3), (p1, p3)]
    [alpha, beta, gamma] = map findAngle [(a, b, c), (b, a, c), (c, a, b)]
    r = a / (2*sin(alpha))
    n = pi/ fgcd alpha (fgcd beta gamma)

readLine :: IO [Double]
readLine = (map read) . words <$> getLine

main =
    readLine >>= \p1 ->
    readLine >>= \p2 ->
    readLine >>= \p3 ->
    print $ findArea [p1, p2, p3]