# Check if a commit message is provided, otherwise use today's date
if ($args.Count -eq 0) {
    $commitMessage = Get-Date -Format "yyyy-MM-dd"
} else {
    $commitMessage = $args[0]
}

# Add changes to the staging area
git add .
if ($?) {
    Write-Host "Changes staged successfully."
} else {
    Write-Host "Error: Failed to add files to staging area."
    exit 1
}

# Commit the changes with the provided or default message
git commit -m $commitMessage
if ($?) {
    Write-Host "Commit successful."
} else {
    Write-Host "Error: Commit failed."
    exit 1
}

# Push the changes to the main branch
git push origin main
if ($?) {
    Write-Host "Push to origin/main successful."
} else {
    Write-Host "Error: Push to origin/main failed."
    exit 1
}

# Execute the count.ps1 script
try {
    .\count.ps1
    Write-Host "PowerShell script executed successfully."
} catch {
    Write-Host "Error: Failed to execute count.ps1."
    exit 1
}

Write-Host "All steps executed successfully."
