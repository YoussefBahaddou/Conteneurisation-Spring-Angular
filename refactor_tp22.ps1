$targetDir = "Smart_Home_back\src\main\java\com\youssef\smarthome"
$testDir = "Smart_Home_back\src\test\java\com\youssef\smarthome"
$dirs = @($targetDir, $testDir)

foreach ($dir in $dirs) {
    Get-ChildItem -Path $dir -Recurse -Filter "*.java" | ForEach-Object {
        $content = Get-Content $_.FullName -Raw
        
        # Replacements
        $content = $content -replace "package com.example.appareil", "package com.youssef.smarthome"
        $content = $content -replace "import com.example.appareil", "import com.youssef.smarthome"
        
        # Classes and Types
        $content = $content -replace "AppareilApplication", "SmartHomeApplication"
        $content = $content -replace "AppareilController", "SmartDeviceController"
        $content = $content -replace "CategorieController", "DeviceCategoryController"
        $content = $content -replace "AppareilRepository", "SmartDeviceRepository"
        $content = $content -replace "CategorieRepository", "DeviceCategoryRepository"
        $content = $content -replace "AppareilService", "SmartDeviceService"
        $content = $content -replace "CategorieService", "DeviceCategoryService"
        
        $content = $content -replace "Appareil", "SmartDevice"
        $content = $content -replace "Categorie", "DeviceCategory"
        
        # Variables (Case sensitive usually, but here we can try basic lowercase replacement if safe, or specific)
        $content = $content -replace "appareil", "smartDevice"
        $content = $content -replace "categorie", "deviceCategory"
        
        # Endpoints
        $content = $content -replace "/api/controller/appareil", "/api/v1/devices"
        $content = $content -replace "/api/controller/categorie", "/api/v1/categories"
        
        # Remove comments (Simple line comments)
        $content = $content -replace "(?m)^\s*//.*`r`n", ""
        $content = $content -replace "(?m)^\s*//.*`n", ""
        
        # Fix typo in package import if it existed from the folder rename
        $content = $content -replace ".cotroller", ".controller"

        Set-Content -Path $_.FullName -Value $content
        Write-Host "Processed $($_.Name)"
    }
}
