$file = Get-Content C:\Users\nico_\Documents\ML\adventofcode\DAY3_POWERSHELL\input_final.txt

$oxygen_gen = New-Object System.Collections.Generic.List[String]
$scrubber = New-Object System.Collections.Generic.List[String]

$len_binary = $file[0].Length

For ($i_b = 0; $i_b -lt $file.Length; $i_b++) {
    $oxygen_gen.Add($file[$i_b])
    $scrubber.Add($file[$i_b])
}


For ($i_b = 0; $i_b -lt $len_binary; $i_b++) {
    $count_1 = 0
    $count_0 = 0
    

    For ($i = 0; $i -lt $oxygen_gen.Count; $i++) {
        if (($oxygen_gen[$i][$i_b]) -eq '0') {
            $count_0 += 1
        }
        else {
            $count_1 += 1
        }
    }
    if ($count_0 -le $count_1) {
        For ($i_c = $oxygen_gen.Count - 1 ; $i_c -ge 0; $i_c--) {
            if ($oxygen_gen[$i_c][$i_b] -eq '0') {
                $oxygen_gen.Remove($oxygen_gen[$i_c]) | Out-Null
            }
        }
    }
    else {
        For ($i_c = $oxygen_gen.Count - 1 ; $i_c -ge 0; $i_c--) {
            if ($oxygen_gen[$i_c][$i_b] -eq '1') {
                $oxygen_gen.Remove($oxygen_gen[$i_c]) | Out-Null
            }
        }
    }

    if ($oxygen_gen.Count -eq 1) {
        break
    }
}

For ($i_b = 0; $i_b -lt $len_binary; $i_b++) {
    $count_1 = 0
    $count_0 = 0
    

    For ($i = 0; $i -lt $scrubber.Count; $i++) {
        if (($scrubber[$i][$i_b]) -eq '0') {
            $count_0 += 1
        }
        else {
            $count_1 += 1
        }
    }
    if ($count_0 -le $count_1) {
        For ($i_c = $scrubber.Count - 1 ; $i_c -ge 0; $i_c--) {
            if ($scrubber[$i_c][$i_b] -eq '1') {
                $scrubber.Remove($scrubber[$i_c]) | Out-Null
            }
        }
    }
    else {
        For ($i_c = $scrubber.Count - 1 ; $i_c -ge 0; $i_c--) {
            if ($scrubber[$i_c][$i_b] -eq '0') {
                $scrubber.Remove($scrubber[$i_c]) | Out-Null
            }
        }
    }

    if ($scrubber.Count -eq 1) {
        break
    }
}

$oxygen_gen = [Convert]::ToInt32($oxygen_gen , 2)
$scrubber = [Convert]::ToInt32($scrubber , 2)
Write-Output ($scrubber * $oxygen_gen)




