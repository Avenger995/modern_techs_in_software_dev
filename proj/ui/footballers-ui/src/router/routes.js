import UrlPath from "../constans/UrlPath";
import TeamsPage from "../pages/TeamsPage";
import PlayersPage from "../pages/PlayersPage";
import FormationPage from "../pages/FormationsPage";
import LoginPage from "../pages/LoginPage";

export const routes = [
    {path: UrlPath.Teams, element: <TeamsPage/>, exact: true},
    {path: UrlPath.Players, element: <PlayersPage/>, exact: true},
    {path: UrlPath.Formations, element: <FormationPage/>, exact: true},
    {path: UrlPath.Login, element: <LoginPage/>, exact: true}    
]

export const loginRoute = routes.find(x => x.path === UrlPath.Login);