$file = Get-Content C:\Users\Roche\Documents\ML\adventofcode\DAY3_POWERSHELL\input_base.txt

$oxygen_gen = New-Object System.Collections.Generic.List[Int32]
$scrubber = New-Object System.Collections.Generic.List[Int32]

Foreach ($elem in $file) {
    $oxygen_gen.Add($elem)
    $scrubber.Add($elem)
}


