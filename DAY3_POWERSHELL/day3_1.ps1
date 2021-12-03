$file = Get-Content C:\Users\Roche\Documents\ML\adventofcode\DAY3_POWERSHELL\input_final.txt
$len_binary = $file[0].Length
$gamma = New-Object System.Collections.Generic.List[Int32]
$epsilon = New-Object System.Collections.Generic.List[Int32]
For ($i_b = 0; $i_b -lt $len_binary; $i_b++) {
    $count_1 = 0
    $count_0 = 0
    For ($i = 0; $i -lt $file.Length; $i++) {
        if (($file[$i][$i_b]) -eq '0') {
            $count_0 += 1
        }
        else {
            $count_1 += 1
        }
    }
    if ($count_0 -lt $count_1) {
        $gamma.Add(1)
        $epsilon.Add(0)
    }
    else {
        $gamma.Add(0)
        $epsilon.Add(1)
    }
}
$gamma = -join $gamma
$gamma = [Convert]::ToInt32($gamma , 2)

$epsilon = -join $epsilon
$epsilon = [Convert]::ToInt32($epsilon , 2)
Write-Output ($epsilon * $gamma)


